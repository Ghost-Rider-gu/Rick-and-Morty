package corp.siendev.com.rickandmorty

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RickAndMortyApplication

fun main(args: Array<String>) {
	runApplication<RickAndMortyApplication>(*args)
}
