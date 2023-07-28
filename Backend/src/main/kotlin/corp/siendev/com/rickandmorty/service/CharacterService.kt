package corp.siendev.com.rickandmorty.service

import corp.siendev.com.rickandmorty.entity.Character
import corp.siendev.com.rickandmorty.repository.CharacterRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CharacterService(private val characterRepository: CharacterRepository) {
    fun getCharacterByName(characterName: String): Optional<Character> {
        return characterRepository.findCharacterByName(characterName)
    }

    fun getAllCharactersBySpecies(species: String): List<Character> {
        return characterRepository.findAllCharactersBySpecies(species)
    }

    fun getAllCharactersByStatus(status: String): List<Character> {
        return characterRepository.findAllCharactersByStatus(status)
    }

    fun getCharacterById(characterId: Long): Optional<Character> {
        return characterRepository.findById(characterId)
    }

    fun getAllCharacters(): List<Character> {
        return characterRepository.findAll()
    }
    fun saveCharacter(character: Character) {
        characterRepository.save(character)
    }

    fun updateCharacter(character: Character) {
        characterRepository.save(character)
    }

    fun deleteCharacter(characterId: Long) {
        characterRepository.deleteById(characterId)
    }
}
