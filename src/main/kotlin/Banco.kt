
class Banco {

    /**
     * Mapa onde sao armazenadas as contas do banco
     */
    private var contas: MutableMap<String, Conta> = mutableMapOf<String, Conta>()

    /**
     * Funcao que realiza credito em uma conta
     *
     * @param valor valor a ser creditado
     * @param numeroConta numero da conta na qual sera creditado o valor
     * @return o resultado do processamento
     */
    fun creditar(valor: Double, numeroConta: String): ResultadoProcessamento {
        val conta = buscarConta(numeroConta)
        if (conta != null) {
            conta.creditar(valor)
            return ResultadoProcessamento.OK
        } else {
            return ResultadoProcessamento.CONTA_INEXISTENTE
        }
    }

    /**
     * Funcao que realiza o debito em uma conta.
     *
     * @param valor o valor a ser debitado
     * @param numeroConta o numero da conta da qual sera debitado o valor
     * @return o resultado do processamento
     */
    fun debitar(valor: Double, numeroConta: String): ResultadoProcessamento {
        // Voce deve implementar a logica da funcao debitar.
        //
        // Use a funcao creditar como exemplo. Observe os retornos possiveis da funcao creditar e pense
        // no que pode acontecer na funcao debitar.
        //
        // OBS: Esta funcao eh usada na funcao sacar no arquivo main.kt,
        // observe o que se espera da funcao debitar por la.

        // ATENCAO: o numero da conta passada pode referenciar uma conta inexistente, o que nao deve ser permitido
        // ATENCAO: o valor a debitar pode ser maior que o saldo da conta, o que nao deve ser permitido
        TODO()
    }

    /**
     * Inclui uma nova conta no banco
     *
     * @param conta a conta a ser incluida
     * @return o resultado do processamento
     */
    fun incluirConta(conta: Conta): ResultadoProcessamento {
        // Voce deve implementar a logica da funcao incluirConta
        //
        // OBS: Essa funcao eh usada pela funcao novaConta no arquivo main.kt,
        // observe o que se espera da funcao incluirConta por la
        //
        // ATENCAO: a nova conta pode ter um numero de uma conta ja existente, o que nao deve ser permitido
        TODO()
    }

    /**
     * Busca uma conta no banco
     *
     * @param numero o numero da conta a ser encontrada.
     *
     *@return a conta que possui o numero passado como parametro, null caso contrario.
     */
    fun buscarConta(numero: String): Conta? {
        return contas[numero]
    }

    /**
     * Realiza a transferencia de valor entre uma conta origem e uma conta destino
     *
     * @param numeroContaOrigem o numero da conta de origem (debito)
     * @param numeroContaDestino o numero da conta de destino (credito)
     * @param valor o valor a ser transferido
     */
    fun transferir(numeroContaOrigem: String, numeroContaDestino: String, valor: Double): ResultadoProcessamento {
        // Voce deve implementar a logica da funcao transferir. Ela deve debitar o valor da conta de origem e
        // creditar o valor na conta de destino.
        //
        // OBS: Essa funcao pela funcao transferencia no arquivo main.kt,
        // observe o que se espera da funcao transferir por la
        //
        // ATENCAO: o numeroContaOrigem pode fazer referencia a uma conta inexistente, o que nao deve ser permitido
        // ATENCAO: o numeroContaDestino pode fazer referencia a uma conta inexistente, o que nao deve ser permitido
        // ATENCAO: o valor pode ser maior que o saldo da conta de origem, o que nao deve ser permitido
        TODO()
    }
}