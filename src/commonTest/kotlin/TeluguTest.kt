import com.github.medavox.ipa_transcribers.brahmic.Telugu
import org.junit.Test

class TeluguTest :CoverageTest() {
    private val unicodeBlock:Array<Int> =a(0x0C00..0x0C7F)
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


    @Test
    fun characterCoverageTest() {
        for(i in unicodeBlock) {
            if (i !in excluded) {
                codePointTest(i, Telugu::transcribe)
            }
        }
    }
}