package corp.siendev.com.rickandmorty.controller

import corp.siendev.com.rickandmorty.entity.Character
import corp.siendev.com.rickandmorty.service.CharacterService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/characters")
class CharacterController(private val characterService: CharacterService) {
    @GetMapping
    fun getAllCharactersByStatus(@RequestParam("status") status: String): List<Character> {
        return characterService.getAllCharactersByStatus(status)
    }

    @GetMapping
    fun getAllCharactersBySpecies(@RequestParam("species") species: String): List<Character> {
        return characterService.getAllCharactersBySpecies(species)
    }

    @GetMapping
    fun getCharacterByName(@RequestParam("name") characterName: String): ResponseEntity<Character> {
        val result = characterService.getCharacterByName(characterName)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getCharacterById(@PathVariable("id") characterId: Long): ResponseEntity<Character> {
        val result = characterService.getCharacterById(characterId)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping
    fun getAllCharacters(): List<Character> {
        return characterService.getAllCharacters()
    }

    @PostMapping
    fun createCharacter(@RequestBody newCharacter: Character) {
        characterService.saveCharacter(newCharacter)
    }

    @PutMapping("/{id}")
    fun updateCharacter(@PathVariable("id") characterId: Long,
                        @RequestBody updatedCharacter: Character) {
        characterService.updateCharacter(updatedCharacter)
    }

    @DeleteMapping("/{id}")
    fun deleteCharacter(@PathVariable("id") characterId: Long) {
        characterService.deleteCharacter(characterId)
    }
}
