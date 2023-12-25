import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MainKtTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun testId() {

        val post = Post(
            0, 11, 22, "text", 1699473307, "https://www.unixtimestamp.com/ru/", "post",
            true, true, true, true, true
        )

        val result = WallService.add(post)

        assertNotEquals(post.id, result)
    }

    @Test
    fun updateTrue() {
        val post = Post(
            1, 11, 22, "text", 1699473307, "https://www.unixtimestamp.com/ru/", "post",
            true, true, true, true, true
        )

        WallService.add(post)
        val result = WallService.update(post)
        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        val post = Post(
            0, 11, 22, "text", 1699473307, "https://www.unixtimestamp.com/ru/", "post",
            true, true, true, true, true
        )

        WallService.add(post)
        val result = WallService.update(post)
        assertFalse(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val post = Post(
            0, 11, 22, "text", 1699473307, "https://www.unixtimestamp.com/ru/", "post",
            true, true, true, true, true
        )
        WallService.add(post)
        WallService.createComment(5, Comment("Замечательные слова!"))
    }

    @Test
    fun commentTrue() {
        val comment = Comment("Замечательные слова!")
        val post = Post(
            0, 11, 22, "text", 1699473307, "https://www.unixtimestamp.com/ru/", "post",
            true, true, true, true, true
        )
        WallService.add(post)
        val result = WallService.createComment(1, comment)
        assertEquals(comment, result)
    }
}