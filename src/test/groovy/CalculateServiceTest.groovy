import com.amura.CalculateService
import spock.lang.Specification

class CalculateServiceTest extends Specification {

    def "should return maximum area of longest sub matrix for given matrix"() {
        given:
        int[][] inputArray = [[1, 0, 0, 0, 0, 1],
                              [0, 1, 1, 1, 0, 0],
                              [0, 1, 1, 1, 0, 0],
                              [0, 0, 0, 1, 0, 0]]

        CalculateService service = new CalculateService()

        when:
        def result = service.getMaxSubMatrix(4, 6, inputArray)

        then:
        result.longestSubMatrixArea == 6

    }

    def "should return maximum area of longest sub matrix as zero for given matrix with all zeros"() {
        given:
        int[][] inputArray = [[0, 0, 0, 0, 0, 0],
                              [0, 0, 0, 0, 0, 0],
                              [0, 0, 0, 0, 0, 0],
                              [0, 0, 0, 0, 0, 0]]

        CalculateService service = new CalculateService()

        when:
        def result = service.getMaxSubMatrix(4, 6, inputArray)

        then:
        result.longestSubMatrixArea == 0

    }

    def "should return maximum area of longest sub matrix same as given matrix"() {
        given:
        int[][] inputArray = [[1, 1, 1, 1, 1, 1],
                              [1, 1, 1, 1, 1, 1],
                              [1, 1, 1, 1, 1, 1],
                              [1, 1, 1, 1, 1, 1]]

        CalculateService service = new CalculateService()

        when:
        def result = service.getMaxSubMatrix(4, 6, inputArray)

        then:
        result.longestSubMatrixArea == 24

    }
}
