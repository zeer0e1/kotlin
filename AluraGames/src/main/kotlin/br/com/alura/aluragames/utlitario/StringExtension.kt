import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.tranformaIdade(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var idade = 0
    val dataNascimento = LocalDate.parse(this, formatter)
    val hoje = LocalDate.now()
    idade = Period.between(dataNascimento,hoje).years
    return idade
}