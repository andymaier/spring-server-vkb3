package io.swagger.api;

import io.swagger.model.Artikel;
import io.swagger.repo.ArtikelRepo;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-12-17T14:30:37.141Z[GMT]")
@RestController
public class ArtikelApiController implements ArtikelApi {


    private ArtikelRepo repo;

    private static final Logger log = LoggerFactory.getLogger(ArtikelApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ArtikelApiController(ObjectMapper objectMapper, HttpServletRequest request, ArtikelRepo repo) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.repo = repo;
    }

    public ResponseEntity<Artikel> artikelAidGet(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("aid") String aid) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Artikel>(objectMapper.readValue("{\n  \"preis\" : 3.99,\n  \"name\" : \"HansWurst\"\n}", Artikel.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Artikel>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Artikel>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Artikel>> artikelGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
        }

        return new ResponseEntity<List<Artikel>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Artikel> artikelPost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody Artikel body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            
                Artikel artiekelCreated = repo.save(body);
                return ResponseEntity.status(HttpStatus.CREATED).body(artiekelCreated);
                //return new ResponseEntity<Artikel>(objectMapper.readValue("{\n  \"preis\" : 3.99,\n  \"name\" : \"HansWurst\"\n}", Artikel.class), HttpStatus.NOT_IMPLEMENTED);
            
        }

        return new ResponseEntity<Artikel>(HttpStatus.NOT_IMPLEMENTED);
    }

}
