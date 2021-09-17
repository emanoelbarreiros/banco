/**
 * Representa o resultao de processamento realizado pela classe Banco
 */
enum class ResultadoProcessamento {
    OK,
    CONTA_INEXISTENTE,
    SALDO_INSUFICIENTE,
    CONTA_EXISTENTE,
    CONTA_ORIGEM_INEXISTENTE,
    CONTA_DESTINO_INEXISTENTE
}