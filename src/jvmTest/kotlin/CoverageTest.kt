import com.ibm.icu.lang.UCharacter
import org.junit.Before
import java.io.ByteArrayOutputStream
import java.io.PrintStream

/**Common functionality when testing that a transcriber covers all possible codepoints in a
 * language's unicode block.*/
abstract class CoverageTest {
    protected val errOut:ByteArrayOutputStream = ByteArrayOutputStream()

    protected fun a(ranged:IntRange):Array<Int> {
        return ranged.toList().toTypedArray()
    }

    protected fun s(ranged:IntRange):Set<Int> {
        return ranged.toSet()
    }

    @Before
    fun redirectErrorStream() {
        System.setErr(PrintStream(errOut))
    }

    /**Checks whether an individual Unicode codepoint is handled by the given transcribe() function.
     * If it's not, it should print something to System.err, which this test function checks for.*/
    fun codePointTest(codePoint:Int, transcribe:(String)->String) {
        val c = codePoint.toChar().toString()
        val hexName = codePoint.toString(16)
        val unicodeName = UCharacter.getName(codePoint)
        System.out.println("testing unicode char $hexName '$c'/$unicodeName")
        val errOutSizeBefore = errOut.size()
        transcribe(c)
        assert(errOutSizeBefore == errOut.size())
    }
}