package com.joalvarez.graphql.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;
import org.springframework.graphql.execution.ErrorType;

@Component
public class CustomGraphQLErrorHandler extends DataFetcherExceptionResolverAdapter {

	@Override
	protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
		String message = ex.getMessage();
		if (ex instanceof GenericException) {
			message = ((GenericException) ex).getInternalCode().message();
		}

		return GraphqlErrorBuilder.newError()
			.errorType(ErrorType.BAD_REQUEST)
			.message(message)
			.path(env.getExecutionStepInfo().getPath())
			.location(env.getField().getSourceLocation())
			.build();
	}
}
