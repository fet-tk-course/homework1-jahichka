open abstract class Instrukcija() {
    abstract fun pomjeri(pozicija: Pair<Int, Int>): Pair<Int, Int>
}

class Gore : Instrukcija() {
    override fun pomjeri(pozicija: Pair<Int, Int>): Pair<Int, Int> {
        return if (pozicija.first > 0) {
            Pair(pozicija.first - 1, pozicija.second)
        } else {
            pozicija
        }
    }
}

class Dole : Instrukcija() {
    override fun pomjeri(pozicija: Pair<Int, Int>): Pair<Int, Int> {
        return if (pozicija.first < 2) {
            Pair(pozicija.first + 1, pozicija.second)
        } else {
            pozicija
        }
    }
}

class Lijevo : Instrukcija() {
    override fun pomjeri(pozicija: Pair<Int, Int>): Pair<Int, Int> {
        return if (pozicija.second > 0) {
            Pair(pozicija.first, pozicija.second - 1)
        } else {
            pozicija
        }
    }
}

class Desno : Instrukcija() {
    override fun pomjeri(pozicija: Pair<Int, Int>): Pair<Int, Int> {
        return if (pozicija.second < 2) {
            Pair(pozicija.first, pozicija.second + 1)
        } else {
            pozicija
        }
    }
}

class Tastatura(private val matrica: Array<Array<Int>> = arrayOf(
    arrayOf(1, 2, 3),
    arrayOf(4, 5, 6),
    arrayOf(7, 8, 9)
)) {
    fun pomjeri(trenutna_pozicija: Pair<Int, Int>, instrukcija: Instrukcija): Pair<Int, Int> {
        return instrukcija.pomjeri(trenutna_pozicija) 
    }
    
    operator fun get(red: Int, kolona: Int): Int {
        return matrica[red][kolona]
    }
}

class Dekoder(private val instrukcije: Array<String>, private val tastatura: Tastatura) {
    fun dekodiraj(): String {
        var sigurnosniKod = ""
        var trenutna_pozicija = Pair(1, 1) // Initialize to position of '5'

        for (instrukcija in instrukcije) {
            for (i in instrukcija) {
                val trenutna_instrukcija = when (i) {
                    '^' -> Gore()
                    'v' -> Dole()
                    '<' -> Lijevo()
                    '>' -> Desno()
                    else -> throw IllegalArgumentException("Nepoznata instrukcija: $i")
                }
                trenutna_pozicija = tastatura.pomjeri(trenutna_pozicija, trenutna_instrukcija)
            }
            val broj = tastatura[trenutna_pozicija.first, trenutna_pozicija.second]
            sigurnosniKod += broj.toString()
        }
        return sigurnosniKod
    }
}

fun main() {
    val tastatura = Tastatura()
    
    val instrukcije = arrayOf(
        "^<<",
        ">>vvv",
        "<^>v<",
        "^^^^v"
    )

    val dekoder = Dekoder(instrukcije, tastatura)
    val sigurnosniKod = dekoder.dekodiraj()
    
    println("Sigurnosni kod: $sigurnosniKod") 
}

