package br.com.alura.forum.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

	// Essa classe será responsável por interceptar as exceptions que forem lançadas
	// nos métodos das classes controller padrão Interceptor do Sprint
	// @RestControllerAdvice

	// Para tratar os erros de validação do Bean Validation e personalizar o JSON,
	// que será devolvido ao cliente da API, com as mensagens de erro, devemos criar
	// um método na classe @RestControllerAdvice e anotá-lo com @ExceptionHandler e
	// @ResponseStatus.

	// @ExceptionHandler informa aos Spring que devemos chamar esse métodos toda vez
	// que houver uma exceção no controller passando o tipo de exceção que será
	// lançada pelo Spring que neste caso é uma exceção de formulário
	// MethodArgumentNotValidException.class

	// @ResponseStatus(code = HttpStatus.BAD_REQUEST) Informa ao Spring que vamos
	// devolver um http status 400 como retorno quando houver uma exceção

	// Usaremos uma classe DTO para retornar as mensagens de erro quando houver uma
	// excessão no controller

	// Essa classe do Spring MessageSource ajuda a obter mensagens de erro

	@Autowired
	private MessageSource messageSoruce;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDTO> handle(MethodArgumentNotValidException exception) {

		List<ErroDeFormularioDTO> dto = new ArrayList<ErroDeFormularioDTO>();

		List<FieldError> errors = exception.getBindingResult().getFieldErrors();

		errors.forEach(e -> {
			String mensagem = messageSoruce.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormularioDTO erro = new ErroDeFormularioDTO(e.getField(), mensagem);
			dto.add(erro);
		});

		return dto;

	}

}
