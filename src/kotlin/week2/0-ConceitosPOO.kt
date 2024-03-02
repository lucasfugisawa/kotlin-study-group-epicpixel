package week2

open class Usuario(
    val id: Int,
    val username: String,
    val senha: String,
    var ativo: Boolean,
    val idade: Int,
) {
    open fun verificaSenha(): Boolean = senha.length >= 3
}

class UsuarioModerador(
    id: Int,
    username: String,
    senha: String,
    ativo: Boolean,
    idade: Int,
): Usuario(id, username, senha, ativo, idade) {
    override fun verificaSenha(): Boolean = senha.length >= 8
    fun verRelatorioModeracao(): String = "15 usuários banidos. WOW!"
}

class UsuarioAdministrativo(
    id: Int,
    username: String,
    senha: String,
    ativo: Boolean,
    idade: Int,
): Usuario(id, username, senha, ativo, idade) {
    override fun verificaSenha(): Boolean = senha.length >= 8
    fun verRelatorioDoSistema(): String = "Estatísticas do sistema: EXCELENTE!"
}


class RepositorioUsuarios {
    val bancoDeDadosDeUsuarios = mutableListOf<Usuario>()

    fun salvar(usuario: Usuario) {
        bancoDeDadosDeUsuarios.add(usuario)
    }

    fun buscar(username: String): Usuario? {
        return bancoDeDadosDeUsuarios.find { it.username == username }
    }

    fun buscarTodos() = bancoDeDadosDeUsuarios
}

fun main() {

    val usuarioComum1 = Usuario(1, "lucas", "123", true, 1)
    val usuarioAdmin1 = UsuarioAdministrativo(2, "admin", "234234345456", true, 2)

//    println(usuarioComum1.verificaSenha())
//    println(usuarioAdmin1.verificaSenha())
//    println(usuarioAdmin1.verRelatorioDoSistema())

    val repositorioUsuarios = RepositorioUsuarios()

    repositorioUsuarios.salvar(Usuario(1, "lucas", "123", true, 40))
    repositorioUsuarios.salvar(UsuarioAdministrativo(2, "led", "123", true, 32))
    repositorioUsuarios.salvar(UsuarioModerador(3, "marcia", "1142141243", true, 30))
    repositorioUsuarios.salvar(UsuarioModerador(4, "talis", "123423423", false, 26))
    repositorioUsuarios.salvar(UsuarioModerador(5, "zeppelin", "123", true, 60))
    repositorioUsuarios.salvar(UsuarioModerador(6, "camila", "123234345", false, 38))

    fun imprimeUsuarios(usuarios: List<Usuario>) {
        for (usuario in usuarios) {
            println(usuario.username)
        }
    }

    // GET https://herdeiros.com.br/api/listarUsuarios
    fun endpointDaApiDeUsuarios_ListarEspeciais() {
        val todosOsUsuarios = repositorioUsuarios.buscarTodos().filter { it is UsuarioModerador || it is UsuarioAdministrativo }
        imprimeUsuarios(todosOsUsuarios)
    }

    endpointDaApiDeUsuarios_ListarEspeciais()

    // média da idade dos usuários ativos que tem senha adequada
    val media = repositorioUsuarios
        .buscarTodos()
        .filter { it.ativo && it.verificaSenha() }
        .map { it.idade }
        .average()

    val todosOsUsuarios = repositorioUsuarios.buscarTodos()
    var somaDasIdades = 0
    var quantidadeDeIdades = 0
    for (usuario in todosOsUsuarios) {
        if (usuario.ativo && usuario.verificaSenha()) {
            somaDasIdades += usuario.idade
            quantidadeDeIdades += 1
        }
    }
    val mediaIdades = somaDasIdades/quantidadeDeIdades
}











