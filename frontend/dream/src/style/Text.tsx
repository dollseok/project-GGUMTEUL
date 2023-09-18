import React from 'react'

// 스타일
import styled, {css} from 'styled-components'

interface TextProps {
  children?: React.ReactNode;
  onClick ?: () => void;
  $nightKeword ?: boolean;

  // 강조
  $isBold ?: boolean;

  // 마진
  $MBHalf ?: boolean

  // 색상
  $nightWhite ?: boolean;
  $nightBlue ?: boolean;
  $black ?: boolean;
  $danger ?: boolean
  
}
const StyledText = styled.div<TextProps>`

  ${(props) =>
    props.$nightKeword &&
    css`
      font-size: 0.75rem;
    `
  }
  ${(props) =>
    props.$isBold &&
    css`
      font-weight: 700;
    `
  }
  ${(props) =>
    props.$MBHalf &&
    css`
      margin-bottom: 0.5rem;
    `
  }
  ${(props) =>
    props.$nightWhite &&
    css`
      color: #F2F2F0;
    `
  }

  ${(props) =>
    props.$nightBlue &&
    css`
      color: #1F4078;
    `
  }
  ${(props) =>
    props.$black &&
    css`
      color: black;
    `
  }
  ${(props) =>
    props.$danger &&
    css`
      color: #C70000;
    `
  }
`

const Text = (props:TextProps) => {
  return <StyledText {...props}>{props.children}</StyledText>
}

export default Text