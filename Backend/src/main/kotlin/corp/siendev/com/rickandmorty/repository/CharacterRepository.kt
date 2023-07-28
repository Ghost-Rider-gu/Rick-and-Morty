package corp.siendev.com.rickandmorty.repository

import corp.siendev.com.rickandmorty.entity.Character
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CharacterRepository: JpaRepository<Character, Long> {
    fun findCharacterByName(characterName: String): Optional<Character>
    fun findAllCharactersBySpecies(species: String): List<Character>
    fun findAllCharactersByStatus(status: String): List<Character>
}
