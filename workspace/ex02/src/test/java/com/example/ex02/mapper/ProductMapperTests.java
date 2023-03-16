package com.example.ex02.mapper;

import com.example.ex02.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@Slf4j
@SpringBootTest
public class ProductMapperTests {
    @Autowired
    ProductMapper productMapper;

    @Test
    public void insertTest(){
        ProductVO productVO = new ProductVO();
        productVO.setProductName("포도");
        productVO.setProductPrice(5000);
        productVO.setProductStock(1);

        productMapper.insert(productVO);
    }

    @Test
    public void updateTest(){
        ProductVO productVO = productMapper.select(1L);
        productVO.setProductName("사과");
        productMapper.update(productVO);
    }


    @Test
    public void assertThatTest(){
//        검증, Assertions.assertThat() : 친절한 오류 설명 및 빠른 단위 테스트 가능
        List<String> datas = new ArrayList<>(Arrays.asList("a","b","c"));
        assertThat(datas.get(0)).isEqualTo("A"); // 값검사
        assertThat(datas).isInstanceOf(ArrayList.class); // 타입검사
        assertThat(datas).isInstanceOfAny(List.class, String.class, ArrayList.class); // 여러 타입 작성 가능 , 1개라도 true면 true
        assertThat(productMapper.select(1L)).extracting("productName"); // 객체의 필드 검사
        assertThat(productMapper.select(1L)).isIn(productMapper.selectAll()); // 자신을 포함한 컬렉션인지 검사
        assertThat(productMapper.select(1L)).isExactlyInstanceOf(ProductVO.class);// 부모 타입이 아닌 본인 타입인지 검사
        assertThat(datas).isSameAs(datas); // 주소비교
        assertThat(datas).isEqualTo(new ArrayList<>(Arrays.asList("a","b","c"))); // 값 비교
        assertThat(datas).contains("A");
        assertThat(datas).element(2); // 인덱스 범위 검사
        assertThat(productMapper.select(1L).getProductPrice()).isLessThan(1000); // 보다 작은지 검사
        assertThat(productMapper.select(1L).getProductPrice()).isLessThanOrEqualTo(1000); // 보다 작은지 검사
    }

    @Test
    public void listTest(){
        assertThat(productMapper.selectAll().get(0).getProductName()).isEqualTo("사과");
    }

}
