/* SPDX-FileCopyrightText: © 2023 Parsley Contributors <https://github.com/j-mie6/Parsley/graphs/contributors>
 * SPDX-License-Identifier: BSD-3-Clause
 */
package parsley.internal.errors

private [parsley] sealed abstract class CaretWidth {
    def width: Int
}
private [parsley] class FlexibleCaret(val width: Int) extends CaretWidth
private [parsley] class RigidCaret(val width: Int) extends CaretWidth
