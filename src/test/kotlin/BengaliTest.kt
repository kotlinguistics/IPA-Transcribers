import com.github.medavox.ipa_transcribers.brahmic.TeluguRuleBased
import com.ibm.icu.lang.UCharacter
import org.junit.Test

class BengaliTest {
    private val bengaliUnicodeBlock = 0x0980..0x09FF
    private val excluded = arrayOf(
        0x0984,
        0x098D,
        0x098E,
        0x0991,
        0x0992,
        0x09A9,
        0x09B1,
        0x09B1,
        0x09B3..0x09B5,
        0x09BA,
        0x09BB,
        0x09C5,
        0x09C6,
        0x09C9,
        0x09CA,
        0x09CA,
        0x09CF..0x09D6,
        0x09D8..0x09DB,
        0x09DE,
        0x09E4,
        0x09E5,
        0x09FF
    )
    @Test
    fun characterCoverageTest() {
        for(i in bengaliUnicodeBlock) {
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