package com.pasteleria.Milsabores.Controller;

import com.pasteleria.Milsabores.Entity.DetalleBoleta;
import com.pasteleria.Milsabores.Service.DetalleBoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/detalles-boleta")
public class DetalleBoletaController {

    @Autowired
    private DetalleBoletaService detalleBoletaService;

    @PostMapping("/saveDetalleBoleta")
    public DetalleBoleta saveDetalleBoleta(@RequestBody DetalleBoleta detalle) {
        return detalleBoletaService.guardar(detalle);
    }

    @PostMapping("/saveDetallesBoletaList")
    public List<DetalleBoleta> saveDetallesBoletaList(@RequestBody List<DetalleBoleta> detalles) {
        return detalleBoletaService.guardarLista(detalles);
    }

    @GetMapping("/listDetallesBoleta")
    public List<DetalleBoleta> listDetallesBoleta() {
        return detalleBoletaService.listarTodos();
    }

    @GetMapping("/getDetalleBoletaById/{id}")
    public DetalleBoleta getDetalleBoletaById(@PathVariable Long id) {
        return detalleBoletaService.buscarPorId(id).orElse(null);
    }

    @GetMapping("/getDetallesBoletaByBoletaId/{idBoleta}")
    public List<DetalleBoleta> getDetallesBoletaByBoletaId(@PathVariable Long idBoleta) {
        return detalleBoletaService.buscarPorIdBoleta(idBoleta);
    }

    @GetMapping("/getDetallesBoletaByPastelId/{idPastel}")
    public List<DetalleBoleta> getDetallesBoletaByPastelId(@PathVariable Long idPastel) {
        return detalleBoletaService.buscarPorIdPastel(idPastel);
    }

    @PutMapping("/updateDetalleBoleta")
    public DetalleBoleta updateDetalleBoleta(@RequestBody DetalleBoleta detalle) {
        return detalleBoletaService.actualizar(detalle);
    }

    @DeleteMapping("/deleteDetalleBoletaById/{id}")
    public String deleteDetalleBoletaById(@PathVariable Long id) {
        return detalleBoletaService.eliminar(id);
    }
}
