package example

import ma.glasnost.orika.MapperFacade
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class App(private val orikaMapperFacade: MapperFacade) : ApplicationRunner {

    override fun run(args: ApplicationArguments) {

        // Maps from PersonSource to PersonDestination
        val src = PersonSource("John", "Smith", 23)
        println(src)   // => "PersonSource(firstName=John, lastName=Smith, age=23)"
        val dest = orikaMapperFacade.map(src, PersonDestination::class.java)
        println(dest)  // => "PersonDestination(givenName=John, sirName=Smith, age=23)"

    }

}

fun main(vararg args: String) {
    runApplication<App>(*args)
}
