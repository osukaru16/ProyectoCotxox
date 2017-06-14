<?php
 require_once 'Conexion.php';
 class Conductor {
    private $id;
    private $nombre;
    private $apellidos;
    private $foto;
    private $libre;
    
    const TABLA = 'conductor';



    public function getId() {
       return $this->id;
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





    public function __construct($id=null, $password, $nombre, $apellidos, $foto, $libre ) {
      $this->id = $id;
      $this->password = $password;
      $this->nombre = $nombre;
      $this->apellidos = $apellidos;
      $this->foto = $foto;
      $this->libre = $libre;



       
    }
    public function guardar(){
       $conexion = new Conexion();
       if($this->existe($this->nickname)) /*Modifica*/ {
          $consulta = $conexion->prepare('UPDATE ' . self::TABLA .' SET password = :password, nombre = :nombre, apellidos = :apellidos, email = :email, telefono = :telefono, foto = :foto WHERE id = :id');

          $consulta->bindParam(':id', $this->id);
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
          $this->id = $conexion->lastInsertId(); //esto es para generar una id automatica
       }
       $conexion = null;
    }


/*
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
    */





    public static function buscarPorId($id){
       $conexion = new Conexion();
       $consulta = $conexion->prepare('SELECT * FROM ' . self::TABLA . ' WHERE id = :id');
       $consulta->bindParam(':id', $id);
       $consulta->execute();
       $registro = $consulta->fetch();
       if($registro){
          return new self($id['id']);
       }else{
          return false;
       }
    }



    public static function buscaLibre(){
       $conexion = new Conexion();
       $consulta = $conexion->prepare('SELECT * FROM ' . self::TABLA . ' WHERE libre = true');
      // $consulta->bindParam(':nickname', $nickname);
       $consulta->execute();
       $registro = $consulta->fetch();
       if($registro){
          return new self($id['id']);
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