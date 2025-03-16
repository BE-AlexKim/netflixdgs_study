package com.example.kihyun.netflixdgs.study.scalars

import com.netflix.graphql.dgs.DgsScalar
import graphql.GraphQLContext
import graphql.execution.CoercedVariables
import graphql.language.StringValue
import graphql.language.Value
import graphql.schema.Coercing
import graphql.schema.CoercingParseLiteralException
import graphql.schema.CoercingSerializeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/**
 *packageName    : com.example.kihyun.netflixdgs.study.scalars
 * fileName       : DateScalar
 * author         : joy58
 * date           : 2025-03-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-16        joy58       최초 생성
 */
@DgsScalar(name = "Date")
class DateScalar: Coercing<LocalDate, String> {

    /** 서버에서 클라이언트로 데이터를 보낼 때 타입을 변환시키는 메서드 **/
    override fun serialize(dataFetcherResult: Any, graphQLContext: GraphQLContext, locale: Locale): String? {
        if( dataFetcherResult is LocalDate ) {
            return dataFetcherResult.format(DateTimeFormatter.ISO_DATE)
        }else {
            throw CoercingSerializeException("유요한 Date가 아닙니다.")
        }
    }

    /** 클라이언트에서 서버로 데이터를 보낼때, 쿼리에 직접 입력한 값을 변환할 수 있는 메서드 **/
    override fun parseLiteral(
        input: Value<*>,
        variables: CoercedVariables,
        graphQLContext: GraphQLContext,
        locale: Locale
    ): LocalDate? {
        if (input is StringValue ) {
            return LocalDate.parse(input.value, DateTimeFormatter.ISO_DATE)
        }else {
            throw CoercingParseLiteralException("값이 유효한 ISO 날짜가 아닙니다.")
        }
    }

    /** 클라이언트에서 서버로 데이터를 보낼 때 variables를 사용한 값을 변환할 수 있는 메서드 **/
    override fun parseValue(input: Any, graphQLContext: GraphQLContext, locale: Locale): LocalDate? {
        return LocalDate.parse(input.toString(), DateTimeFormatter.ISO_DATE)
    }
}