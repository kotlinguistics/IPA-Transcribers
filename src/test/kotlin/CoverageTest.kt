import com.ibm.icu.lang.UCharacter
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

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

    @Test
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