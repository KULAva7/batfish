package org.batfish.datamodel.routing_policy.expr;

import java.io.Serializable;
import java.util.List;

import org.batfish.datamodel.routing_policy.Environment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "class")
@JsonInclude(Include.NON_DEFAULT)
public interface AsPathListExpr extends Serializable {

   List<Integer> evaluate(Environment environment);

}
