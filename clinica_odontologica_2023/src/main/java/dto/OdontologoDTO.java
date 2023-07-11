package dto;

import com.example.clinica_odontologica_2023.entity.Odontologo;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OdontologoDTO {
    private String apellido;
    private String nombre;
    private String matricula;

    public OdontologoDTO(){}

    public OdontologoDTO(String apellido, String nombre, String matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    //getters y setters

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public OdontologoDTO entidadDTO(Odontologo odontologo){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(odontologo,OdontologoDTO.class);
    }
}
