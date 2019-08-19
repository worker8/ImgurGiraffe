import java.io.File
import java.io.FileInputStream
import java.util.*

object Secrets {
    private const val IMGUR_API_KEY = "IMGUR_API_KEY"
    private const val IMGUR_API_SECRET = "IMGUR_API_SECRET"

    val imgurApiKey = apiKeysProperties().getProperty(IMGUR_API_KEY)
    val imgurApiSecret =  apiKeysProperties().getProperty(IMGUR_API_SECRET)
    private fun apiKeysProperties(): Properties {
        val filename = "api_keys.properties"
        val file = File(filename)
        if (!file.exists()) {
            throw Error(
                "You need to prepare a file called $filename in the project root directory.\n" +
                    "and contain the IMGUR API key and REDDIT API key.\n" +
                    "the content of the file should look something like:\n\n" +
                    "(project root)$ cat $filename\n" +
                    "$IMGUR_API_KEY=abcde123253\n"
            )
        }
        val properties = Properties()
        properties.load(FileInputStream(file))
        return properties
    }
}
