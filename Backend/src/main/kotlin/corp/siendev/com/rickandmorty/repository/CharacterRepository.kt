package corp.siendev.com.rickandmorty.repository

import corp.siendev.com.rickandmorty.entity.Character
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CharacterRepository: JpaRepository<Character, Long> {
    fun getCharacterByName(characterName: String): Optional<Character>
    fun getCharactersBySpecies(species: String): List<Character>
    fun getCharactersByStatus(status: String): List<Character>
}
