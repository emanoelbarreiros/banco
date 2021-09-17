fun main(args: Array<String>) {
    val banco = Banco()
    println("=======================")
    println("Bem-vindo ao banco UPE.")
    println("=======================")
    while(true) {
        println("\nInforme a opcao desejada e pressione ENTER:")
        println("1 - nova conta")
        println("2 - depositar")
        println("3 - sacar")
        println("4 - transferencia")
        println("5 - obter saldo")

        val opcao = readLine()!!
        when (opcao) {
            "1" -> novaConta(banco)
            "2" -> depositar(banco)
            "3" -> sacar(banco)
            "4" -> transferencia(banco)
            "5" -> saldo(banco)
            else -> println("Opcao não reconhecida. Tente novamente")
        }
    }
}

fun novaConta(banco: Banco) {
    println(">> Você escolheu a opcão para criacão de uma nova conta.")
    print("Digite o número da conta: ")
    val numero = readLine()!!
    val conta = Conta(numero)
    val resultado = banco.incluirConta(conta)
    when (resultado) {
        ResultadoProcessamento.OK -> println("\n >> Conta incluída com sucesso.")
        ResultadoProcessamento.CONTA_EXISTENTE -> println("\n >> Já existe conta cadastrada com este número.")
        else -> return
    }
}

fun depositar(banco: Banco) {
    println(">> Você escolheu a opcão de depósito.")
    print("Digite o número da conta: ")
    val numero = readLine()!!

    print("Digite o valor a ser depositado (incluindo os centavos): ")
    val valor = readLine()!!.toDoubleOrNull()
    if (valor != null) {
        val resultado = banco.creditar(valor, numero)
        when(resultado) {
            ResultadoProcessamento.OK -> println(" >> Valor depositado com sucesso.")
            ResultadoProcessamento.CONTA_INEXISTENTE -> println(" >> Conta inexistente.")
            else -> return
        }
    } else {
        println(" >> Valor digitado não é um número válido.")
    }
}

fun sacar(banco: Banco) {
    println(">> Você escolheu a opcão saque.")
    print("Digite o número da conta: ")
    val numero = readLine()!!
    print("Digite o valor a ser sacado (incluindo os centavos): ")
    val valor = readLine()!!.toDoubleOrNull()
    if (valor != null) {
        val resultado = banco.debitar(valor, numero)
        when (resultado) {
            ResultadoProcessamento.OK -> println(" >> Valor debitado com sucesso.")
            ResultadoProcessamento.CONTA_INEXISTENTE -> println(" >> Conta inexistente.")
            ResultadoProcessamento.SALDO_INSUFICIENTE -> println(" >> Saldo insuficiente para saque.")
            else -> return
        }
    } else {
        println(" >> Valor digitado não é um número válido.")
    }
}

fun transferencia(banco: Banco) {
    println(">> Você escolheu a opcão transferência.")
    print("Digite o número da conta de origem: ")
    val numeroOrigem = readLine()!!

    print("Digite o número da conta de destino: ")
    val numeroDestino = readLine()!!

    print("Digite o valor a ser transferido: ")
    val valor = readLine()!!.toDoubleOrNull()

    if (valor != null) {
        val resultado = banco.transferir(numeroOrigem, numeroDestino, valor)
        when (resultado) {
            ResultadoProcessamento.OK -> println(" >> Valor transferido com sucesso.")
            ResultadoProcessamento.SALDO_INSUFICIENTE -> println(" >> Saldo insuficiente para débito na conta de origem.")
            ResultadoProcessamento.CONTA_ORIGEM_INEXISTENTE -> println(" >> Conta de origem inexistente.")
            ResultadoProcessamento.CONTA_DESTINO_INEXISTENTE -> println(" >> Conta de destino inexistente.")
            else -> return
        }
    } else {
        println(" >> Valor digitado não é um número válido.")
    }


}

fun saldo(banco: Banco) {
    println(">> Você escolheu a opcão de saldo.")
    print("Informe o número da conta: ")
    val numero = readLine()!!
    val conta = banco.buscarConta(numero)
    if (conta != null) {
        println(" >> Saldo da conta de número $numero: R\$ ${conta.saldo}")
    } else {
        println(" >> Conta inexistente.")
    }
}