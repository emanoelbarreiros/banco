/**
 * Representa a conta do banco
 */
data class Conta(val numero: String) {
    var saldo: Double = 0.0
        private set

    fun creditar(valor: Double) {
        saldo += valor
    }

    fun debitar(valor: Double): Boolean {
        if (valor <= saldo) {
            saldo -= valor
            return true
        } else {
            return false
        }
    }
}