/*
 * Copyright 2019. the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ms.dew.auth.dto.management

import javax.validation.constraints.NotNull
import ms.dew.auth.domain.{Resource, Role}
import ms.dew.auth.dto.common.StatusDTO
import ms.dew.auth.helper.CommonConverter

import scala.beans.BeanProperty
import scala.collection.JavaConverters._


case class RoleAddReq() extends StatusDTO {

  @NotNull
  @BeanProperty
  var name: String = _
  @BeanProperty
  var tenantId: String = ""
  @BeanProperty
  var resourceIds: java.util.Set[Int] = new java.util.HashSet()

}

object RoleAddReq {

  implicit def convert(ori: RoleAddReq): Role = {
    val role = CommonConverter.convert[Role](ori)
    role.resources = ori.resourceIds.asScala.map(Resource(_)).asJava
    role
  }

}

