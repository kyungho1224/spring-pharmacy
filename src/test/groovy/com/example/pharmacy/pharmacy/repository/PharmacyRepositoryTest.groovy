package com.example.pharmacy.pharmacy.repository

import com.example.pharmacy.AbstractIntegrationContainerBaseTest
import com.example.pharmacy.pharmacy.entity.Pharmacy
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by KimKyungHo on 2024-02-15(015)
 */

class PharmacyRepositoryTest extends AbstractIntegrationContainerBaseTest {

    /*

    JPA 이용하여 CRUD 테스트 코드를 작성할 때 DB 환경
    1. 운영환경과 유사한 스펙의 DB(개발 환경 DB) 사용
    2. 인메모리 DB(H2) 사용하기
    3. Docker 사용
    4. TestContainers 사용
    - TestContainers 는 운영환경과 유사한 DB 스펙으로 독립적인 환경에서 테스트 코드를 작성하여 테스트가 가능
    - 테스트 코드가 실행될 때 자동으로 도커 컨테이너를 실행하여 테스트하고,
    테스트가 끝나면 자동으로 컨테이너를 종료 및 정리
     */

    @Autowired
    PharmacyRepository pharmacyRepository;

//    def setup() {
//        pharmacyRepository.deleteAll()
//    }

    def "PharmacyRepository save"() {
        given:
        String address = "서울 특별시 성북구 종암동"
        String name = "은혜 약국"
        double latitude = 36.11
        double longitude = 128.11

        def pharmacy = Pharmacy.builder()
                .pharmacyAddress(address)
                .pharmacyName(name)
                .latitude(latitude)
                .longitude(longitude)
                .build()

        when:
        def result = pharmacyRepository.save(pharmacy)

        then:
        result.getPharmacyAddress() == address
        result.getPharmacyName() == name
        result.getLatitude() == latitude
        result.getLongitude() == longitude
    }

    def "PharmacyRepository saveAll"() {
        given:
        String address = "서울 특별시 성북구 종암동"
        String name = "은혜 약국"
        double latitude = 36.11
        double longitude = 128.11

        def pharmacy = Pharmacy.builder()
                .pharmacyAddress(address)
                .pharmacyName(name)
                .latitude(latitude)
                .longitude(longitude)
                .build()

        when:
        pharmacyRepository.saveAll(Arrays.asList(pharmacy))
        def result = pharmacyRepository.findAll()

        then:
        result.size() == 1
    }

}
