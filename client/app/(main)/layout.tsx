import type { Metadata } from "next";
import { SidebarProvider, SidebarTrigger } from "@/components/ui/sidebar";
import { AppSidebar } from "@/components/App-Sidebar";

export const metadata: Metadata = {
  title: "Simon",
};

export default function MainLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <SidebarProvider>
      <AppSidebar />
      <main className="w-full h-full">
        <SidebarTrigger className="fixed top-4" />
        <section className="h-full">{children}</section>
      </main>
    </SidebarProvider>
  );
}
