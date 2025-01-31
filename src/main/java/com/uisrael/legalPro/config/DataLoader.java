package com.uisrael.legalPro.config;

import com.uisrael.legalPro.models.*;
import com.uisrael.legalPro.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ICasoRepository casoRepository;

    @Autowired
    private ISeguimientoRepository seguimientoRepository;

    @Autowired
    private ITareaRepository tareaRepository;

    @PostConstruct
    public void loadData() {
        Random random = new Random();

        // Create and save Usuarios
        List<Usuario> usuarios = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Usuario usuario = new Usuario();
            usuario.setNombre("Usuario " + i);
            usuario.setRol("Rol " + i);
            usuario.setEmail("usuario" + i + "@example.com");
            usuario.setTelefono("123456789" + i);
            usuarios.add(usuario);
        }
        usuarioRepository.saveAll(usuarios);

        // Create and save Clientes
        List<Cliente> clientes = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Cliente cliente = new Cliente();
            cliente.setFechaCreacion(new Date());
            cliente.setDni("DNI" + random.nextInt(10000));
            cliente.setNombres("Nombre " + i);
            cliente.setApellidos("Apellido " + i);
            cliente.setTelefono("987654321" + i);
            cliente.setEmail("cliente" + i + "@example.com");
            clientes.add(cliente);
        }
        clienteRepository.saveAll(clientes);

        // Create and save Casos
        List<Caso> casos = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Caso caso = new Caso();
            caso.setFechaCreacion(new Date());
            caso.setFechaActualizacion(new Date());
            caso.setTipo("Tipo " + i);
            caso.setDescripcion("Descripcion del caso " + i);
            caso.setEstado("Estado " + i);
            caso.setCliente(clientes.get(i - 1));
            casos.add(caso);
        }
        casoRepository.saveAll(casos);

        // Create and save Seguimientos
        List<Seguimiento> seguimientos = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Seguimiento seguimiento = new Seguimiento();
            seguimiento.setFechaCreacion(new Date());
            seguimiento.setFechaActualizacion(new Date());
            seguimiento.setFechaLimite(new Date());
            seguimiento.setEstado("Estado " + i);
            seguimiento.setDescripcion("Descripcion del seguimiento " + i);
            seguimiento.setRecordatorio(random.nextBoolean());
            seguimiento.setCaso(casos.get(i - 1));
            seguimientos.add(seguimiento);
        }
        seguimientoRepository.saveAll(seguimientos);

        // Create and save Tareas
        List<Tarea> tareas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Tarea tarea = new Tarea();
            tarea.setFechaCreacion(new Date());
            tarea.setFechaActualizacion(new Date());
            tarea.setFechaLimite(new Date());
            tarea.setEstado("Estado " + i);
            tarea.setDescripcion("Descripcion de la tarea " + i);
            tarea.setPrioridad(random.nextInt(5) + 1);
            tarea.setUsuario(usuarios.get(i - 1));
            tarea.setCaso(casos.get(i - 1));
            tareas.add(tarea);
        }
        tareaRepository.saveAll(tareas);
    }
}