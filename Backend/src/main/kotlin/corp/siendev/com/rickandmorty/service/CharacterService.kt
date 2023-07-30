package corp.siendev.com.rickandmorty.service

import corp.siendev.com.rickandmorty.entity.Character
import corp.siendev.com.rickandmorty.repository.CharacterRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class CharacterService(private val characterRepository: CharacterRepository) {
    fun getCharacterByName(characterName: String): Character {
        return characterRepository.findCharacterByName(characterName)
            .orElseThrow { EntityNotFoundException("Couldn't find character by name: $characterName") }
    }

    fun getAllCharactersBySpecies(species: String): List<Character> {
        return characterRepository.findAllCharactersBySpecies(species)
    }

    fun getAllCharactersByStatus(status: String): List<Character> {
        return characterRepository.findAllCharactersByStatus(status)
    }

    fun getCharacterById(characterId: Long): Character {
        return characterRepository.findById(characterId)
            .orElseThrow { EntityNotFoundException("Couldn't find character by id: $characterId") }
    }

    fun getAllCharacters(): List<Character> {
        return characterRepository.findAll()
    }
    fun saveCharacter(character: Character) {
        characterRepository.save(character)
    }

    fun updateCharacter(character: Character) {
        if (characterRepository.existsById(character.id)) {
            characterRepository.save(Character(
                character.id,
                character.name,
                character.status,
                character.species,
                character.origin,
                character.image,
                character.episodes
            ))
        } else {
            throw EntityNotFoundException("Couldn't find character by id: ${character.id}")
        }
    }

    fun deleteCharacter(characterId: Long) {
        if (characterRepository.existsById(characterId)) {
            characterRepository.deleteById(characterId)
        } else {
            throw EntityNotFoundException("Couldn't find character by id: $characterId")
        }
    }
}
