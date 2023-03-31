package dpawleta.restapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks
    PostService postService;

    @Test
    void shouldCapitalizeSecondWordInString() {
        //given
        String testString = "test content string";
        String expectedStringFromMethod = "test Content string";

        //when
        String stringFromMethod = postService.capitalizeSecondWordInString(testString);

        //then
        assertEquals(expectedStringFromMethod, stringFromMethod);
    }

    @Test
    void shouldNotCapitalizeSecondWordInString() {
        //given
        PostService postService = new PostService(null, null);
        String testString = "testcontentstring";

        //when
        String stringFromMethod = postService.capitalizeSecondWordInString(testString);

        //then
        assertEquals(testString, stringFromMethod);
    }
}
