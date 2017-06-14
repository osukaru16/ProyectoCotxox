<?php
 require_once 'Conexion.php';
 class Conductor {
    private $user;
    private $password;
    private $nombre;
    private $apellidos;
    private $foto;
    private $libre;
    
    const TABLA = 'conductor';



    public function getUser() {
       return $this->user;
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
     public function getFoto() {
       return $this->foto;
    }
    public function getLibre(){
      return $this->libre;
    }



    //Nota no he hecho setUser por que se supone que no puedes cambiar tu user.


   
    public function setPassword($password) {
      $this->password = $password;
    }
    public function setNombre($nombre) {
      $this->nombre = $nombre;
    }
    public function setApellidos($apellidos) {
      $this->apellidos = $apellidos;
    }
     public function setFoto($foto) {
      $this->foto = $foto;
    }
    public function setLibre($libre) {
      $this->libre = $libre;
    }





    public function __construct($user, $password, $nombre, $apellidos, $foto, $libre) {
      $this->user = $user;
      $this->password = $password;
      $this->nombre = $nombre;
      $this->apellidos = $apellidos;
      $this->foto = $foto;
      $this->libre = $libre;
       
    }


    public function guardar(){
       $conexion = new Conexion();
       if($this->existe($this->user)) /*Modifica*/ {
          $consulta = $conexion->prepare('UPDATE ' . self::TABLA .' SET password = :password, nombre = :nombre, apellidos = :apellidos,  foto = :foto, libre = :libre WHERE user = :user');

          $consulta->bindParam(':user', $this->user);
          $consulta->bindParam(':password', $this->password);
          $consulta->bindParam(':nombre', $this->nombre);
          $consulta->bindParam(':apellidos', $this->apellidos);
          $consulta->bindParam(':foto', $this->foto);
          $consulta->bindParam(':libre', $this->libre);
          $consulta->execute();

       }else /*Inserta*/ {
          $consulta = $conexion->prepare('INSERT INTO ' . self::TABLA .' (user, password, nombre, apellidos, foto, libre ) VALUES(:user, :password, :nombre, :apellidos, :foto, :libre)');
          $consulta->bindParam(':user', $this->user);
          $consulta->bindParam(':password', $this->password);
          $consulta->bindParam(':nombre', $this->nombre);
          $consulta->bindParam(':apellidos', $this->apellidos);
          $consulta->bindParam(':foto', $this->foto);
          $consulta->bindParam(':libre', $this->libre);
          $consulta->execute();
          //$this->id = $conexion->lastInsertId(); //esto es para generar una id automatica
       }
       $conexion = null;
    }



  public function existe($user){
      $conexion = new Conexion();
      $consulta = $conexion->prepare('SELECT user FROM ' . self::TABLA . ' WHERE user = :user');
      $consulta->bindParam(':user', $this->user);
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
    





    public static function buscarPorId($user){
       $conexion = new Conexion();
       $consulta = $conexion->prepare('SELECT * FROM ' . self::TABLA . ' WHERE user = :user');
       $consulta->bindParam(':user', $user);
       $consulta->execute();
       $registro = $consulta->fetch();
       if($registro){
          return new self($user['user']);
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






    public static function buscaLibre(){
       $conexion = new Conexion();
       $consulta = $conexion->prepare('SELECT nombre FROM ' . self::TABLA . ' WHERE libre = true');
      // $consulta->bindParam(':nickname', $nickname);
       $consulta->execute();
       $registro = $consulta->fetch();
       
       return $registro;
    }


  public static function prueba(){
    return "Prueba";
  }


















 }
?>