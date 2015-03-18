package com.acework.js.components.bootstrap

import com.acework.js.utils.{Mappable, Mergeable}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js.{UndefOr, undefined}

/**
 * Created by weiyin on 10/03/15.
 */
object Label extends BootstrapComponent {
  override type P = Props
  override type S = Unit
  override type B = Unit
  override type N = TopNode

  override def defaultProps = Props()

  // defaults are based on getDefaultProps
  case class Props(bsClass: UndefOr[Classes.Value] = Classes.label,
                   bsStyle: UndefOr[Styles.Value] = Styles.default,
                   bsSize: UndefOr[Sizes.Value] = undefined,
                   addClasses: String = "") extends BsProps with MergeableProps[Props] {

    def merge(t: Map[String, Any]): Props = implicitly[Mergeable[Props]].merge(this, t)

    def asMap: Map[String, Any] = implicitly[Mappable[Props]].toMap(this)
  }

  override val component = ReactComponentB[Props]("Label")
    .render { (P, C) =>
    // TODO props spread
    <.span(^.classSet1M(P.addClasses, P.bsClassSet))(C)
  }.build

}