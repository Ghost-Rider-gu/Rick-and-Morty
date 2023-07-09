package corp.siendev.com.rickandmorty.repository

import corp.siendev.com.rickandmorty.entity.Character
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CharacterRepository: JpaRepository<Character, Long> {
    fun getCharacterByName(characterName: String): Character
    fun getCharactersBySpecies(species: String): List<Character>
    fun getCharactersByStatus(status: String): List<Character>
}
