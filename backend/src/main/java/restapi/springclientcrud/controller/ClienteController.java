package restapi.springclientcrud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import restapi.springclientcrud.exception.UniqueViolationException;
import restapi.springclientcrud.model.Cliente;
import restapi.springclientcrud.service.ClienteService;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@Validated
public class ClienteController {

    private ClienteService clienteService;

    ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente")
    public List findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity findById(@PathVariable long id) {

        return clienteService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/cliente")
    public Cliente create(@Valid @RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @Valid @RequestBody Cliente cliente) {

        return clienteService.findById(id)
                .map(record -> {

                    record.setNome(cliente.getNome());
                    record.setSexo(cliente.getSexo());
                    record.setEmail(cliente.getEmail());
                    record.setNaturalidade(cliente.getNaturalidade());
                    record.setNacionalidade(cliente.getNacionalidade());
                    record.setCpf(cliente.getCpf());
                    record.setDataNascimento(cliente.getDataNascimento());

                    Cliente updated = clienteService.save(record);

                    return ResponseEntity.ok().body(updated);

                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {

        return clienteService.findById(id)
                .map(record -> {

                    clienteService.deleteById(id);
                    return ResponseEntity.ok().build();

                }).orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ArrayList handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ArrayList errors = new ArrayList();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            HashMap<String, String> errorMap = new HashMap<>();

            String fieldName = ((FieldError) error).getField();
            errorMap.put("field", fieldName);

            String errorMessage = error.getDefaultMessage();
            errorMap.put("message", errorMessage);

            errors.add(errorMap);
        });

        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ ConstraintViolationException.class })
    public ArrayList handleConstraintViolationException(ConstraintViolationException ex) {
        ArrayList errors = new ArrayList();

        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            HashMap<String, String> errorMap = new HashMap<>();

            String errorMessage = violation.getMessage();
            errorMap.put("message", errorMessage);

            errors.add(errorMap);
        }

        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ArrayList handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
        ArrayList errors = new ArrayList();

        HashMap<String, String> errorMap = new HashMap<>();

        String errorMessage = ex.getName() + " deveria ser do tipo " + ex.getRequiredType().getName();

        errorMap.put("message", errorMessage);
        errors.add(errorMap);

        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ UniqueViolationException.class })
    public ArrayList handleUniqueViolationException(UniqueViolationException ex) {
        ArrayList errors = new ArrayList();

        HashMap<String, String> errorMap = new HashMap<>();

        errorMap.put("message", ex.getMessage());
        errors.add(errorMap);

        return errors;
    }
}
