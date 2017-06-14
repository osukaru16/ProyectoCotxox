<?php
 require_once 'Conexion.php';
 class Usuario {
    private $nickname;
    private $password;
    private $nombre;
    private $apellidos;
    private $email;
    private $telefono;
    private $foto;
    
    const TABLA = 'usuario';



    public function getNickname() {
       return $this->nickname;
    }
      public function getPassword() {
       return $this->password;
    }
    public function getNombre() {
       return $this->nombre;
    }
    public function getApellidos() {
       return $this->apellidos;
    }
     public function getEmail() {
       return $this->email;
    }
    public function getTelefono() {
       return $this->telefono;
    }
     public function getFoto() {
       return $this->foto;
    }



    //Nota no he hecho setNikname por que se supone que no puedes cambiar tu nickname.


   
    public function setPassword($password) {
      $this->password = $password;
    }
    public function setNombre($nombre) {
      $this->nombre = $nombre;
    }
    public function setApellidos($apellidos) {
      $this->apellidos = $apellidos;
    }
    public function setEmail($email) {
      $this->email = $email;
    }
    public function setTelefono($telefono) {
      $this->telefono = $telefono;
    }
     public function setFoto($foto) {
      $this->foto = $foto;
    }





    public function __construct($nickname, $password, $nombre, $apellidos, $email, $telefono, $foto ) {
      $this->nickname = $nickname;
      $this->password = $password;
      $this->nombre = $nombre;
      $this->apellidos = $apellidos;
      $this->email = $email;
      $this->telefono = $telefono;
      $this->foto = $foto;



       
    }
    public function guardar(){
       $conexion = new Conexion();
       if($this->existe($this->nickname)) /*Modifica*/ {
          $consulta = $conexion->prepare('UPDATE ' . self::TABLA .' SET password = :password, nombre = :nombre, apellidos = :apellidos, email = :email, telefono = :telefono, foto = :foto WHERE nickname = :nickname');

          $consulta->bindParam(':nickname', $this->nickname);
          $consulta->bindParam(':password', $this->password);
          $consulta->bindParam(':nombre', $this->nombre);
          $consulta->bindParam(':apellidos', $this->apellidos);
          $consulta->bindParam(':email', $this->email);
          $consulta->bindParam(':telefono', $this->telefono);
          $consulta->bindParam(':foto', $this->foto);
          $consulta->execute();

       }else /*Inserta*/ {
          $consulta = $conexion->prepare('INSERT INTO ' . self::TABLA .' (nickname, password, nombre, apellidos, email, telefono, foto ) VALUES(:nickname, :password, :nombre, :apellidos, :email, :telefono, :foto)');
          $consulta->bindParam(':nickname', $this->nickname);
          $consulta->bindParam(':password', $this->password);
          $consulta->bindParam(':nombre', $this->nombre);
          $consulta->bindParam(':apellidos', $this->apellidos);
          $consulta->bindParam(':email', $this->email);
          $consulta->bindParam(':telefono', $this->telefono);
          $consulta->bindParam(':foto', $this->foto);
          $consulta->execute();
          //$this->id = $conexion->lastInsertId(); //esto es para generar una id automatica
       }
       $conexion = null;
    }



  public function existe($nickname){
      $conexion = new Conexion();
      $consulta = $conexion->prepare('SELECT nickname FROM ' . self::TABLA . ' WHERE nickname = :nickname');
      $consulta->bindParam(':nickname', $this->nickname);
      $consulta->execute();
      $registro = $consulta->rowCount();
      //echo "AKI: ".$consulta."</br>";
      if($registro == 0){
        $conexion = null;
        return false;
      }else{
        $conexion = null;
        return true;
      }



    }
    





    public static function buscarPorId($nickname){
       $conexion = new Conexion();
       $consulta = $conexion->prepare('SELECT * FROM ' . self::TABLA . ' WHERE nickname = :nickname');
       $consulta->bindParam(':nickname', $nickname);
       $consulta->execute();
       $registro = $consulta->fetch();
       if($registro){
          return new self($nickname['nickname']);
       }else{
          return false;
       }
    }
    public static function recuperarTodos(){
       $conexion = new Conexion();
       $consulta = $conexion->prepare('SELECT * FROM ' . self::TABLA . ' ORDER BY nombre');
       $consulta->execute();
       $registros = $consulta->fetchAll();
       return $registros;
    }
 }
?>