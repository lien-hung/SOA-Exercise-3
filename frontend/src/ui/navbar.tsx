import Link from 'next/link';
import Logo from './logo';
import styles from './layout.module.css';

export default function Navbar() {
  return (
    <header className={styles.navbar}>
      <div className={styles.container}>
        <Logo />
        <div className={styles.navElements}>
          <ul>
            <li><Link href="/">Trang chủ</Link></li>
            <li><Link href="/customers">Khách hàng</Link></li>
            <li><Link href="/orders">Đơn hàng</Link></li>
          </ul>
        </div>
      </div>
    </header>
  )
}