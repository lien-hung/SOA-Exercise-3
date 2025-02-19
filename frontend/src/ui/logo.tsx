import Image from 'next/image';
import Brand from '@/public/logo.png';
import styles from '@/ui/layout.module.css';

export default function Logo() {
  return (
    <div className={styles.logo}>
      <Image src={Brand} alt="Company logo" width={40} height={40} />
      <p>Lorem Ipsum</p>
    </div>
  )
}