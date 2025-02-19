import Navbar from '@/ui/navbar';
import styles from '@/ui/layout.module.css';

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html>
      <body className={styles.body}>
        <Navbar />
        <main className={styles.main}>{children}</main>
      </body>
    </html>
  )
}