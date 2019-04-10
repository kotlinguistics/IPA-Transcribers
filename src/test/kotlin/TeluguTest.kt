import com.github.medavox.ipa_transcribers.brahmic.TeluguRuleBased
import com.ibm.icu.lang.UCharacter
import org.junit.Test

class TeluguTest {
    private val FIRST_TELUGU_UNICODE_CHAR =0x0C00
    private val LAST_TELUGU_UNICODE_CHAR = 0x0C7F
    private val excluded:Array<Int> = arrayOf(
        0x0c0D,
        0x0C11,
        0x0C29,
        *a(0x0C3A..0x0C3C),
        0x0C45,
        0x0C49,
        *a(0x0C4E..0x0C55),
        0x0C57,
        *a(0x0C5B..0x0C5F),
        0x0C64,
        0x0C65,
        *a(0x0C70..0x0C76)
    )

    private fun IntRange.toArray():Array<Int> {
        return this.toList().toTypedArray()
    }

    private fun a(ranged:IntRange):Array<Int> {
        return ranged.toList().toTypedArray()
    }
    @Test
    fun characterCoverageTest() {
        excluded.forEach {System.out.println(it.toString(16)) }
        for(i in FIRST_TELUGU_UNICODE_CHAR..LAST_TELUGU_UNICODE_CHAR) {
            if(i !in excluded) {
                val c = i.toChar().toString()
                val hexName = i.toString(16)
                val unicodeName = UCharacter.getName(i)
                System.out.println("testing unicode char $hexName '$c'/$unicodeName")
                TeluguRuleBased.transcribe(c)
            }
        }
    }
}