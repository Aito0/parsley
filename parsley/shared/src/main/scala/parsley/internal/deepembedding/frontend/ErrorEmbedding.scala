/*
 * Copyright 2020 Parsley Contributors <https://github.com/j-mie6/Parsley/graphs/contributors>
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */
package parsley.internal.deepembedding.frontend

import parsley.internal.deepembedding.backend, backend.StrictParsley

private [parsley] final class ErrorLabel[A](p: LazyParsley[A], label: String, labels: Seq[String]) extends Unary[A, A](p) {
    override def make(p: StrictParsley[A]): StrictParsley[A] = new backend.ErrorLabel(p, label, labels)

    // $COVERAGE-OFF$
    override def visit[T, U[+_]](visitor: LazyParsleyIVisitor[T, U], context: T): U[A] = visitor.visit(this, context)(p, label, labels)

    override private [parsley] def debugName = "label"
    // $COVERAGE-ON$
}
private [parsley] final class ErrorHide[A](p: LazyParsley[A]) extends Unary[A, A](p) {
    override def make(p: StrictParsley[A]): StrictParsley[A] = new backend.ErrorHide(p)

    // $COVERAGE-OFF$
    override def visit[T, U[+_]](visitor: LazyParsleyIVisitor[T, U], context: T): U[A] = visitor.visit(this, context)(p)

    override private[parsley] def debugName: String = "errorHide"
    // $COVERAGE-ON$
}
private [parsley] final class ErrorExplain[A](p: LazyParsley[A], reason: String) extends Unary[A, A](p) {
    override def make(p: StrictParsley[A]): StrictParsley[A] = new backend.ErrorExplain(p, reason)

    // $COVERAGE-OFF$
    override def visit[T, U[+_]](visitor: LazyParsleyIVisitor[T, U], context: T): U[A] = visitor.visit(this, context)(p, reason)

    override private[parsley] def debugName = "explain"
    // $COVERAGE-ON$
}

private [parsley] final class ErrorAmend[A](p: LazyParsley[A], partial: Boolean) extends Unary[A, A](p) {
    override def make(p: StrictParsley[A]): StrictParsley[A] = new backend.ErrorAmend(p, partial)

    // $COVERAGE-OFF$
    override def visit[T, U[+_]](visitor: LazyParsleyIVisitor[T, U], context: T): U[A] = visitor.visit(this, context)(p, partial)

    override private[parsley] def debugName = "amend"
    // $COVERAGE-ON$
}
private [parsley] final class ErrorEntrench[A](p: LazyParsley[A]) extends Unary[A, A](p) {
    override def make(p: StrictParsley[A]): StrictParsley[A] = new backend.ErrorEntrench(p)

    // $COVERAGE-OFF$
    override def visit[T, U[+_]](visitor: LazyParsleyIVisitor[T, U], context: T): U[A] = visitor.visit(this, context)(p)

    override private[parsley] def debugName = "entrench"
    // $COVERAGE-ON$
}
private [parsley] final class ErrorDislodge[A](n: Int, p: LazyParsley[A]) extends Unary[A, A](p) {
    override def make(p: StrictParsley[A]): StrictParsley[A] = new backend.ErrorDislodge(n, p)

    // $COVERAGE-OFF$
    override def visit[T, U[+_]](visitor: LazyParsleyIVisitor[T, U], context: T): U[A] = visitor.visit(this, context)(n, p)

    override private[parsley] def debugName = "dislodge"
    // $COVERAGE-ON$
}

private [parsley] final class ErrorLexical[A](p: LazyParsley[A]) extends Unary[A, A](p) {
    override def make(p: StrictParsley[A]): StrictParsley[A] = new backend.ErrorLexical(p)

    // $COVERAGE-OFF$
    override def visit[T, U[+_]](visitor: LazyParsleyIVisitor[T, U], context: T): U[A] = visitor.visit(this, context)(p)

    override private[parsley] def debugName = "markAsToken"
    // $COVERAGE-ON$
}
