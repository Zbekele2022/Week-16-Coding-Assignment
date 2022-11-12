package com.promineotech.jeep.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

  @Validated //turns bean validation on
  @RequestMapping("/Jeeps")
  @OpenAPIDefinition(info = @Info(title = "Jeep Sales Service"), servers = {
           @Server(url = "http://localhost:8080", description = "Local server.")})

public interface JeepSalesController {

//@formatter:off
    @Operation(

      summary = " Returns a list of Jeeps",
      description = " Returns a list of Jeeps given in an optional model and/or trim",
      responses = {
            @ApiResponse(
                responseCode ="200",
                description ="A list of Jeeps Returned",
                content = @Content(mediaType = "Application/Jason",
                schema = @Schema(implementation =Jeep.class))),
            @ApiResponse(
                responseCode ="400",
                description ="The request parameter was invalid",
                content = @Content(mediaType ="Application/Jason")),
            @ApiResponse(
                responseCode ="404",
                description = "No Jeeps were found with these input criteria ",
                content = @Content(mediaType ="Application/Jason")),
            @ApiResponse(
                responseCode ="500",
                description = "An unplanned error was occurred ",
                content = @Content(mediaType ="Application/Jason")),
                },

            parameters = {
                @Parameter(
                    name = "model",
                    allowEmptyValue = false,
                    required = false,
                    description = "The model name(i.e., 'WRANGLER')"),
              @Parameter(
                  name = "trim",
                  allowEmptyValue = false,
                  required = false,
                  description = "The Trim level(i.e., 'Sport'")

      }

      )
             @GetMapping
             @ResponseStatus(code = HttpStatus.OK)
             List<Jeep> fetchJeeps(
                 @RequestParam(required = false)
                     JeepModel model,
                 @RequestParam(required = false)
                     String trim);

           //@formatter: on
        }

