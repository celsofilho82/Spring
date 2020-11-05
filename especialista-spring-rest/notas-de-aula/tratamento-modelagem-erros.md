# Tratamento e modelagem de erros da API

Neste módulo vamos trabalhar com o tratamento de exceptions e modelagem desses erros

## Lançando exceções customizadas anotadas com @ResponseStatus

Ao inserimos a anotação ```@ResponseStatus``` especificando o código de ```HttpStatus``` de retorno em uma classe de exceção, quando a mesma for lançada será eviado também para o cliente da API o código de retorno especificado. Podemos passar além do status http um ```reason``` que vai representar a mensagem de erro retornada para o cliente.

ex:
```@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Entidade não encontrada")``` 

## Lançando exceções do tipo ResponseStatusException

