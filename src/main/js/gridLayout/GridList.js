import styled from "styled-components";

const GridList = styled.div`
    display: flex;
    margin-top: 20px;
    margin-bottom: 20px;
    flex-wrap: wrap;
    list-style:none;
    margin-right: 100px;
    margin-left: 100px;
    justify-content: space-around;
    @media (min-width: 768px) {
        margin-right: 0;
        margin-left: 0;
    }
`;

export default GridList;