package com.GestionBilioteca.GestionBiliotecaXBa.Controller;

import com.GestionBilioteca.GestionBiliotecaXBa.Model.Genero;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.Libro;
import com.GestionBilioteca.GestionBiliotecaXBa.exception.ResourceNotFoundException;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.LibroCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class LibroController {

    @Autowired
    private LibroCrudRepository libroRepository;

    @GetMapping("/libros")
    public List<Libro> listarLibros(){
        return (List<Libro>) libroRepository.findAll();

    }

   // @GetMapping("/libros/{generos}")
    //public ResponseEntity<List<Libro>> listarLibrosGenero(@PathVariable List<Genero> generos){
      //   List<Libro> libro =libroRepository.findByGeneros_GeneroInOrderByNombreAsc(generos);

        //         if(libro.isEmpty()){
          //           throw new ResourceNotFoundException("No se encuentran los libros por los géneros: " + generos);
            //     }
        //return ResponseEntity.ok(libro);

    //}

    @GetMapping("/libros/stock/{stock}")
    public  List<Libro> ListarStock(@PathVariable Integer stock ){
        return  libroRepository.findByStockLessThan(stock);
    }

    @GetMapping("/libros/libro/{nombre}")
    public ResponseEntity<Libro> libro(@PathVariable String nombre){
          Libro libro =libroRepository.findByNombre(nombre).orElseThrow(() -> new ResourceNotFoundException("No Se encuentra el libro por el nombre "+ nombre));
          return ResponseEntity.ok(libro);
    }

    @PostMapping("/libros")
    public Libro guardar(@RequestBody Libro libro){
        return libroRepository.save(libro);
    }

    @PutMapping("/libros/{id}")
    public ResponseEntity<Libro> ActualizarLibro(@PathVariable Integer id,@RequestBody Libro libroRequest){
       Libro libro =libroRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El libro con ese id no existe "+ id));

       libro.setNombre(libroRequest.getNombre());
       libro.setAutor(libroRequest.getAutor());
       libro.setYear(libroRequest.getYear());
       libro.setStock(libroRequest.getStock());
       libro.setLibroGeneros(libroRequest.getLibroGeneros());
       libro.setImagen(libroRequest.getImagen());
       Libro libroActualizado=libroRepository.save(libro);

       return ResponseEntity.ok(libroActualizado);
    }


   @DeleteMapping("/libros/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminar(@PathVariable Integer id){
        Libro libro =libroRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El libro con ese id no existe "+ id));
        libroRepository.delete(libro);
        Map<String,Boolean> response =new HashMap<>();
        response.put("deleted" ,Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
