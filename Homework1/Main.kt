open abstract class Instrukcija() {
    abstract fun pomjeri(pozicija: Pair<Int,Int>)
    :Pair<Int,Int>;
}

class Gore(): Instrukcija() {
    override fun pomjeri(pozicija: Pair<Int,Int>)
    :    Pair<Int,Int>{
        val nova_pozicija = if(pozicija.first > 0) {
            Pair(pozicija.first-1, pozicija.second)
        } else{
            pozicija
        }
        return nova_pozicija
    }
}
class Dole(): Instrukcija() {
    override fun pomjeri(pozicija: Pair<Int,Int>)
    :    Pair<Int,Int>{
        val nova_pozicija = if(pozicija.first < 2) {
            Pair(pozicija.first+1, pozicija.second)
        } else{
            pozicija
        }
        return nova_pozicija
    }
}
class Lijevo(): Instrukcija() {
    override fun pomjeri(pozicija: Pair<Int,Int>)
    :    Pair<Int,Int>{
        val nova_pozicija = if(pozicija.second > 0) {
            Pair(pozicija.first, pozicija.second-1)
        } else{
            pozicija
        }
        return nova_pozicija
    }
}
class Desno(): Instrukcija() {
    override fun pomjeri(pozicija: Pair<Int,Int>)
    :    Pair<Int,Int>{
        val nova_pozicija = if(pozicija.second < 2) {
            Pair(pozicija.first, pozicija.second+1)
        } else{
            pozicija
        }
        return nova_pozicija
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
    
}



fun main() {
    
}
