package dto;

import com.example.clinica_odontologica_2023.entity.Paciente;
import com.example.clinica_odontologica_2023.entity.Turno;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDTO {
    private String paciente;
    private String odontologo;
    private LocalDate fechaHora;

    public TurnoDTO(){}

    public TurnoDTO(String paciente, String odontologo, LocalDate fechaHora) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaHora = fechaHora;
    }

    //getters y setters

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(String odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public static TurnoDTO buildTurnoDTO(Turno turno){
        String paciente = turno.getPaciente().getApellido()+" "+turno.getPaciente().getNombre();
        String odontologo = turno.getOdontologo().getApellido()+" "+turno.getOdontologo().getNombre();
        return new TurnoDTO(paciente,odontologo,turno.getFechaHora());
    }
}
