package scala.build.preprocessing

final case class Scoped[T](path: ScopePath, value: T) {
  def appliesTo(candidate: ScopePath): Boolean =
    path.root == candidate.root &&
    candidate.subPath.startsWith(path.subPath)
  def valueFor(candidate: ScopePath): Option[T] =
    if (appliesTo(candidate)) Some(value) else None
}
