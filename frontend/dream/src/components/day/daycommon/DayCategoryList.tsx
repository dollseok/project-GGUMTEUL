
// map
// <CategoryBox></CategoryBox>

// 리액트
import React, { SetStateAction, Dispatch, useEffect, useState } from "react";
import Text from "style/Text";
import styled from "styled-components";

// 외부 라이브러리
import tokenHttp from "api/tokenHttp";

// 컴포넌트

// 스타일
import Button from "components/common/Button";

const CategoryWrap = styled.div`
  /* margin: 0.5rem; */
`

const CategoryListWrap = styled.div`
  margin: 1rem 0;
  overflow-x: scroll;
  white-space: nowrap;
  display: flex;
  gap: 0.5rem;
`

export interface CategoryAxiosType {
  keyword :string,
  keywordId :number,
}

export interface CategoryPropsType {
  setCategoryProps :Dispatch<SetStateAction<CategoryAxiosType>>
}

const DayCategoryList = (props :CategoryPropsType) => {
  const [categoryList, setCategoryList] = useState<CategoryAxiosType[]>([]);
  const [select, setSelect] = useState<number>(-1);

  // axios 요청
  const getCategory = () => {
    tokenHttp.get(`/day/keyword/list`)
    .then((res) => {
      setCategoryList(res.data.data);
    })
    .catch((err) => console.log(err))
  }

  useEffect(() => {
    getCategory();
  }, []);

  useEffect(() => {
    if (select === 0) {
      props.setCategoryProps({
        keyword: "",
        keywordId: 0,
      })
    }
  }, [select, setSelect])

  return (
    <>
    <CategoryWrap>
      <CategoryListWrap>
        {
          categoryList?.map((category, i) => 
            <Button 
            onClick={() => {
              props.setCategoryProps(category);
              // 눌렀던 버튼 다시 눌렀을 때 : 키워드 지정 취소
              if (select === category.keywordId) {setSelect(0)}
              else {setSelect(category.keywordId);}
            }}
            $category 
            $isSelected={select === category.keywordId ? true : false}
            key={i}
            >{category.keyword}</Button>
          )
        }
      </CategoryListWrap>
    </CategoryWrap>
    </>
  )
}

export default DayCategoryList